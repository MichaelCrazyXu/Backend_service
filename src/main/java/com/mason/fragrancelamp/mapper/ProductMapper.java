package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.Product;
import com.mason.fragrancelamp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from product_tbl")
    List<Product> getProducts();

    @Insert("insert into product_tbl(pid,pname) " +
            "values (#{pid},#{name})")
    void addProduct(Product product);

    @Select("select * from product_tbl where pid = #{pid}")
    Product getProductByID(@Param("pid") String pid);

    @Update({"<script>",
            "update product_tbl",
            "<set>",
            "<if test='pid != null'>",
            "pid = #{pid} ,",
            "</if>",
            "<if test='pname != null'>",
            "pname = #{pname} ,",
            "</if>",
            "</set>",
            "where pid = #{pid}",
            "</script>"})
    int updateProduct(Product product);

    @Delete("delete from product_tbl where pid = #{pid}")
    int deleteProduct(@Param("pid") String pid);
}
