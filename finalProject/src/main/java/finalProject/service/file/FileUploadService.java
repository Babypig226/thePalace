package finalProject.service.file;


import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
@Service
public class FileUploadService {
	
	public String fileUpload(MultipartFile mf, String filePath){
		String store = "";
		if(mf != null) {
			String orginalFileName = mf.getOriginalFilename();  
			String originalFileExtension = 	orginalFileName.substring(orginalFileName.lastIndexOf("."));
			store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			File file = new File(filePath + "/" + store);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return store;
	}
	
	public String multipleFileUpload(MultipartFile[] arrmf, String filePath){
		String totalStore = "";
		for (MultipartFile mf : arrmf) {
			String original = mf.getOriginalFilename();  
			String originalFileExtension = 	original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "")+ originalFileExtension; 
			File file = new File(filePath + "/" + store);
			totalStore += store+"`";
			try {
				mf.transferTo(file);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return totalStore;
	}


}
