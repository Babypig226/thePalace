package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDTO {
	String goodsNo;
	String goodsType;
	String goodsCategory;
	Timestamp goodsReg;
	String goodsName;
	String goodsPrice;
	String goodsContent;
	String goodsQty;
	String goodsImage;
	Integer goodsCount;
}
