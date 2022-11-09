package com.oumuanode.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.oumuanode.domain.Department;
import com.oumuanode.domain.ResultInfo;
import com.oumuanode.service.DepartmentService;
import com.oumuanode.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/department/*")
public class DepartmentServlet extends BaseServlet {

   private DepartmentService departmentService = (DepartmentService) new DepartmentServiceImpl();

    /**
     * 显示部门
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void departmentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentService.findAll();
        for (Department department : departments){
            System.out.println(department);
        }
//        它提供一些功能将转换成Java对象匹配JSON结构
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        //writeValue（参数，obj）：直接将传入的对象序列化为json，并且返回给客户端
        //writeValueAsString（obj）：将传入的对象序列化为json，返回给调用者
        mapper.writeValue(response.getOutputStream(), departments);
    }

    /**
     * 删除部门
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String did_Str = request.getParameter("did");
        int did = Integer.parseInt(did_Str);
        departmentService.deleteDepartmentById(did);

        departmentService.deleteDepartmentById(did);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(), info);
    }



    public void addDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String department = request.getParameter("department");
        departmentService.addDepartment(department);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(), info);
    }
}
