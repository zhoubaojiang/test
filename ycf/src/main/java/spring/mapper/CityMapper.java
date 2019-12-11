package spring.mapper;

import java.util.List;

import spring.pagemodel.CityAnalysis;
import spring.po.City;
import spring.po.Country;


public interface CityMapper {
	List<City> getCitys();
	List<City> getCountrycity(String countryname);//获取某国家城市列表
	Country getCitysbyCountry(String countryname);
	List<City> selectCitysByName(List<Integer> countryIds);
	
	List<CityAnalysis> analysisCitys();
}
