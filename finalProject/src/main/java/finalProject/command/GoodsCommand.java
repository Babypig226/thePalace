package finalProject.command;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCommand {
	String goodsNo;
	String goodsType;
	String goodsCategory;
	String goodsName;
	String goodsPrice;
	String goodsContent;
	String goodsQty;
	MultipartFile goodsImage;
	Integer goodsCount;
	
	

}
