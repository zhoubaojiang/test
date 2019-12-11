package spring.mapper;

import spring.po.Staff;



public interface LoginMapper {
	Staff getpwdbyname(String name);
}
