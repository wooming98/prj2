package com.prj2.mapper;

import com.prj2.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    @Insert("""
        INSERT INTO board (title, content)
        VALUES (#{title}, #{content})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);


    @Select("""
    SELECT id, title, content, inserted
    FROM board
    WHERE id = #{id};
""")
    Board selectById(Integer id);

//    @Select("""
//        SELECT *
//        FROM board
//        ORDER BY id DESC
//        """)
//    List<Board> selectAll();

    @Delete("""
        DELETE FROM board
        WHERE id = #{id};
        """)
    int deleteById(Integer id);

    @Update("""
        UPDATE board
        SET title=#{title},
            content=#{content}
        WHERE id=#{id};
    """)
    int update(Board board);

    @Select("""
        SELECT *
        FROM board
        ORDER BY id DESC
        LIMIT #{offset}, 10
        """)
    List<Board> selectAllByPage(int offset);

    @Select("""
    SELECT COUNT(*)
    FROM board;
    """)
    int countAll();
}
