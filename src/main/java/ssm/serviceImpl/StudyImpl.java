package ssm.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.dao.StudentMapper;
import ssm.model.Student;
import ssm.service.Study;

import java.util.List;
import java.util.Map;

@Service
    public class StudyImpl implements Study {
        @Autowired
        @Qualifier("studentMapper")
        private StudentMapper studentMapper;



        /**
         * 添加学生
         * @param student
         * @return 学生ID
         */
        public int addStudent(Student student){

            int i = studentMapper.addStudent(student);
            return student.getStudent_Id();
        }


        /**
         * 根据学生ID删除学生 true or false
         * @param i
         * @return true or false
         */
        public boolean delete(int i){
            int a = studentMapper.deleteStudent(i);
            if (a==0){
                return false;
            }
            return true;
        }

        /**
         * 根据学生ID修改学生信息
         * @param student
         * @return 修改是否成功
         */
        public boolean update(Student student) {
           int i = studentMapper.updateStudent(student);
            if (i==0){return false;}
            return true;
        }


        /**
         * 查询所有学生信息
         * @return List<Student>
         */
        public List<Student> findAll1() {
                //SqlSession对象

            List<Student> list = studentMapper.queryAll();
            return list;
        }

        /**
         * 根据学生姓名查询学生信息
         * @param s
         * @return List<Student>
         */
        public List<Student> findByName(String s) {
            List<Student> list = studentMapper.queryByName(s);
            return list;
        }

        /**
         * 根据学号查询学生信息
         * @param i
         * @return
         */
        public List<Student> findByLearnNumber(int i) {
            List<Student> list = studentMapper.queryByLearnNumber(i);
            return list;
        }

        public boolean addAll1(List<Student> list) {
            int i = studentMapper.addAll(list);
            if (i==0){
                return false;
            }
            return true;
        }


            public PageInfo<Student> findByPage(int currentPage, int pageSize) {
            PageHelper.startPage(currentPage, pageSize);
            List<Student> list = studentMapper.queryAll();
            PageInfo<Student> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }

    /**
     * mybatis物理分页查询
     * @param currPage
     * @param pageSize
     * @return
     */
        @Override
        public List<Student> findAll(int currPage, int pageSize) {
            Map<String, Object> data = new HashedMap();
            data.put("currIndex", (currPage-1)*pageSize);
            data.put("pageSize", pageSize);
            //return studentMapper.findAll(data);
            List<Student> list = studentMapper.findAll(data);
            return list;
        }

        @Override
        public int queryCount() {
            int i = studentMapper.queryCount();
            return i;
        }


    }
