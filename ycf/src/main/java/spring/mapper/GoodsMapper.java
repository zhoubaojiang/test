package spring.mapper;

import spring.goods.dto.request.GoodsListReq;
import spring.goods.dto.request.RecommendedRequest;
import spring.goods.dto.response.RecommendedResponse;
import spring.model.PGoods;

import java.util.List;

public interface GoodsMapper {
    List<PGoods> selectGoodsList(GoodsListReq request);

    List<RecommendedResponse> selectRecommendedlist(RecommendedRequest requset);

    List<RecommendedResponse> searchlist(RecommendedRequest requset);
}
