package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select({"<script>",
            "select * from product_tbl ",
            "WHERE 1=1",
            "<when test='product_name!=null and product_name != \"\"'>",
            "AND product_name like CONCAT('%',#{product_name},'%') ",
            "</when>",
            "<when test='product_type_id!=null and product_type_id != \"\"'>",
            "AND product_type_id = #{product_type_id}",
            "</when>",
            "order by id ${sort} limit #{limit} offset #{limit}*(#{page} - 1)",
            "</script>"})
    List<Product> getProducts(PageRequest pageRequest);

    @Select({"<script>",
            "select count(id) from product_tbl ",
            "WHERE 1=1",
            "<when test='product_name!=null and product_name != \"\"'>",
            "AND product_name like CONCAT('%',#{product_name},'%') ",
            "</when>",
            "<when test='product_type_id!=null and product_type_id != \"\"'>",
            "AND product_type_id = #{product_type_id}",
            "</when>",
            "</script>"})
    int getTotalCount(PageRequest pageRequest);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into product_tbl(product_name," +
            "product_type_id,product_description,create_time) " +
            "values (#{product_name}," +
            " #{product_type_id}," +
            " #{product_description}," +
            " now())")
    void addProduct(Product product);

    @Select("select * from product_tbl where pid = #{id}")
    Product getProductByID(@Param("id") String id);

    @Update({"<script>",
            "update product_tbl",
            "<set>",
            "<if test='product_name != null'>",
            "product_name = #{product_name} ,",
            "</if>",
            "<if test='product_type_id != null'>",
            "product_type_id = #{product_type_id} ,",
            "</if>",
            "<if test='product_description != null'>",
            "product_description = #{product_description} ,",
            "</if>",
            "</set>",
            "where id = #{id}",
            "</script>"})
    int updateProduct(Product product);

    @Delete("delete from product_tbl where id = #{id}")
    int deleteProduct(@Param("id") int id);
}
