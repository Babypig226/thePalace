package finalProject.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdWishDTO {
	String userId;
	String goodsNo;
	List<GoodsDTO> gd;
}
