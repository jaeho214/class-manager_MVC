package com.dev.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.dev.domain.Assignment;
import com.dev.domain.FileVO;
import com.dev.domain.Member;
import com.dev.service.Impl.AssignmentServiceImpl;
import com.dev.service.Impl.FileServiceImpl;

@Controller
public class AssignmentController {
	private AssignmentServiceImpl assignmentService;
	private FileServiceImpl fileServiceImpl;

    public AssignmentController(AssignmentServiceImpl assignmentService, FileServiceImpl fileServiceImpl){
        this.assignmentService = assignmentService;
        this.fileServiceImpl = fileServiceImpl;
    }

 // 로그인된 아이디로 게시글 리스트 출력
 	@GetMapping("/assignment")
 	public String assignment(HttpSession session) {
 		Member mem = (Member) session.getAttribute("member");
 		List<Assignment> assignmentList = assignmentService.selectAssignment(mem.getId());
 		session.setAttribute("assignmentList", assignmentList);
 		return "assignment";
 	}
 		
 // 새로운 과제 등록
 	@PostMapping("/assignment.do")
 	public String assignment_do(Assignment assignment, @RequestPart MultipartFile files, HttpSession session) throws Exception{
 		Member mem = (Member) session.getAttribute("member");
 		assignment.setUser_id(mem.getId());
 		FileVO file = new FileVO();
 		if(files.isEmpty()){ //업로드할 파일이 없을 시
 			assignment.setFno(0L);
            assignmentService.InsertNewAssignment(assignment);
        }else{
            String fileName = files.getOriginalFilename(); 
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase(); 
            File destinationFile; 
            String destinationFileName; 
            String fileUrl = "C:/Users/HYUN-JAEHO/git/repository2/ClassManager/src/main/webapp/WEB-INF/uploadFiles/";
            
            do { 
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension; 
                destinationFile = new File(fileUrl+ destinationFileName); 
            } while (destinationFile.exists()); 
            
            destinationFile.getParentFile().mkdirs(); 
            files.transferTo(destinationFile); 
            
            
            file.setFilename(destinationFileName);
            file.setFileoriName(fileName);
            file.setFileUrl(fileUrl);
            fileServiceImpl.insertFile(file);
            long fno = fileServiceImpl.selectRecentNo();
            assignment.setFno(fno);
            assignmentService.InsertNewAssignementIncludeFile(assignment);
        }

 		List<Assignment> assignmentList = assignmentService.selectAssignment(mem.getId());
 		session.setAttribute("assignmentList", assignmentList);
 		
 		
 		return "assignment";
 	}
 	
 // 과제 수정
 	@GetMapping("/assignmentUpdate")
 	public String assignmentUpdate(@RequestParam(value="ano")Long ano, HttpSession session) {
 		Assignment assignment = assignmentService.selectAnoAssignment(ano);
 		session.setAttribute("assignment", assignment);
 		return "assignmentUpdate";
 	}
 	

 	// 과제 수정 완료
 	@PostMapping("/assignmentUpdate.do")
 	public String assignmentUpdate_do(Assignment assignment, @RequestPart MultipartFile files, HttpSession session) throws Exception{
 		FileVO file = new FileVO();
 		
 		if(files.isEmpty()){ //업로드할 파일이 없을 시
 			assignment.setFno(0L);
            assignmentService.AssignmentUpdate(assignment);
        }else{
            String fileName = files.getOriginalFilename(); 
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase(); 
            File destinationFile; 
            String destinationFileName; 
            String fileUrl = "C:/Users/HYUN-JAEHO/git/repository2/ClassManager/src/main/webapp/WEB-INF/uploadFiles/";
            
            do { 
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension; 
                destinationFile = new File(fileUrl+ destinationFileName); 
            } while (destinationFile.exists()); 
                
            destinationFile.getParentFile().mkdirs();    
            files.transferTo(destinationFile); 
   
            if(assignment.getFno()==0) {
            	file.setFilename(destinationFileName);
                file.setFileoriName(fileName);
                file.setFileUrl(fileUrl);
                fileServiceImpl.insertFile(file);
                long fno = fileServiceImpl.selectRecentNo();
                assignment.setFno(fno);
                
            }else {
            	file.setFilename(destinationFileName);
                file.setFileoriName(fileName);
                file.setFileUrl(fileUrl);
                file.setFno(assignment.getFno());
                fileServiceImpl.updateFile(file);
            }
 
            assignmentService.AssignmentUpdate(assignment);
            
        }

 		Member mem = (Member)session.getAttribute("member");
 		List<Assignment> assignmentList = assignmentService.selectAssignment(mem.getId());
 		session.setAttribute("assignmentList", assignmentList);
 		return "assignment";
 	}
 	
 	// 과제 삭제
 	@GetMapping("/assignmentDelete")
 	public String assignmentDelete(@RequestParam(value="ano") Long ano, HttpSession session) {
 		Assignment assignment = assignmentService.selectFno(ano);
 		System.out.println(ano);
 		System.out.println(assignment.getContent());
 		if(assignment.getFno() == null) {
 			System.out.println("22222");
 			assignmentService.deleteAssignment(ano); 			
 		}else {
 			System.out.println("3333");
 			assignmentService.deleteAssignment(ano); 			 			
 			System.out.println("4444");
 			fileServiceImpl.deleteFile(assignment.getFno());
 		}
 		Member mem = (Member)session.getAttribute("member");
 		List<Assignment> assignmentList = assignmentService.selectAssignment(mem.getId());
 		session.setAttribute("assignmentList", assignmentList);
 		return "assignment";
 	}
 	
 	//파일 다운로드
 	@GetMapping("/fileDown")
 	public void fileDown(@RequestParam(value="fno")long fno, HttpServletRequest request, HttpServletResponse response) throws Exception{
 		FileVO fileVO = fileServiceImpl.selectFile(fno);
 		//파일 업로드된 경로 
        try{
            String fileUrl = fileVO.getFileUrl();
            fileUrl += "/";
            String savePath = fileUrl;
            String fileName = fileVO.getFilename();
            
            //실제 내보낼 파일명 
            String oriFileName = fileVO.getFileoriName();
            InputStream in = null;
            OutputStream os = null;
            File file = null;
            boolean skip = false;
            String client = "";
            
            //파일을 읽어 스트림에 담기  
            try{
                file = new File(savePath, fileName);
                in = new FileInputStream(file);
            } catch (FileNotFoundException fe) {
                skip = true;
            }
            
            client = request.getHeader("User-Agent");
            
            //파일 다운로드 헤더 지정 
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Description", "JSP Generated Data");
            
            if (!skip) {
                // IE
                if (client.indexOf("MSIE") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                    // IE 11 이상.
                } else if (client.indexOf("Trident") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                } else {
                    // 한글 파일명 처리
                    response.setHeader("Content-Disposition",
                            "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                    response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
                }
                response.setHeader("Content-Length", "" + file.length());
                os = response.getOutputStream();
                byte b[] = new byte[(int) file.length()];
                int leng = 0;
                while ((leng = in.read(b)) > 0) {
                    os.write(b, 0, leng);
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
            }
            in.close();
            os.close();
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }

 	}
}
