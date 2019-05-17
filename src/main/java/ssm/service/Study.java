package ssm.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import ssm.model.Student;

import java.util.List;

@Service
public interface Study {
    /**
     * 添加学生
     * @param student
     * @return 学生ID
     */
    public int addStudent(Student student);

    //根据学生ID删除学生 返回 true/false
    public boolean delete(int i);

    //根据学生ID修改学生信息 返回true/false
    public boolean update(Student student);

    //查询所有学生信息 返回list集合
    public List findAll1();

    //根据学生姓名查询学生信息，返回List集合
    public List findByName(String s);

    //根据学生学号查询学生信息并返回 List集合
    public List findByLearnNumber(int i);

    //批量插入学生
    public boolean addAll1(List<Student> list);

    /**
     *
     * @param currentPage 当前页
     * @param pageSize 每页的数据大小
     * @return
     */
    public PageInfo<Student> findByPage(int currentPage, int pageSize);

    //物理分页
    public List<Student> findAll(int currPage,int pageSize);

    public  int  queryCount();


}
