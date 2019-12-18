package spring.mapper.cvs;

import org.apache.ibatis.annotations.Param;
import spring.goods.dto.request.GoodsListReq;
import spring.goods.dto.request.RecommendedRequest;
import spring.goods.dto.response.RecommendedResponse;
import spring.model.PGoods;
import spring.wechat.dto.result.PayOrderGoodsNumRes;

import java.util.List;

public interface GoodsMapper {
    List<PGoods> selectGoodsList(GoodsListReq request);

    List<RecommendedResponse> selectRecommendedlist(RecommendedRequest requset);

    List<RecommendedResponse> searchlist(RecommendedRequest requset);

    List<PayOrderGoodsNumRes> selectOrderGoodsNum(@Param("orderNo")String orderNo);
}
