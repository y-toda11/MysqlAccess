package com.example.MysqlAccess;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MysqlAccessController {
	@Autowired	// This means to get the bean called CustomerRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private CustomerRepository customerRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
    public String index() {
		// DBアクセスTop画面を表示
        return "index.html";
    }
	
	// 顧客名簿
	@GetMapping(path="/all")
	public String list(Model model) {
		// M_CUSTOMERテーブルの全データを取得
		Iterable<Customer> customerList = customerRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("customerlist",customerList);

		// データ一覧画面を表示
		return "list.html";
	}
	
	@RequestMapping("/insert")
    public String insert() {
		// データ登録画面を表示
        return "insert.html";
    }
	
	// DB登録処理
	@PostMapping(path="/register")
	public @ResponseBody String addNewCustomer(	  @RequestParam String c_num 
												, @RequestParam String c_name
												, @RequestParam String address
												, @RequestParam String tel) {
		
		Customer customerAddData = new Customer();
		customerAddData.setAll(c_num,c_name,address,tel);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		customerAddData.setCreate_date(timestamp);
		customerAddData.setCreate_user("auto_system");
		customerAddData.setUpdate_date(timestamp);
		customerAddData.setUpdate_user("auto_system");
		
		customerRepository.save(customerAddData);
		
		return "登録しました";
	}
	
	// 部署マスタ
	@GetMapping(path="/all_dp")
	public String list_dp(Model model) {
		// M_DEPARTMENTテーブルの全データを取得
		Iterable<Department> departmentList = departmentRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("departmentlist",departmentList);

		// データ一覧画面を表示
		return "list_dp.html";
	}
	
	@RequestMapping("/insert_dp")
    public String insert_dp() {
		// データ登録画面を表示
        return "insert_dp.html";
    }
	
	// DB登録処理
	@PostMapping(path="/register_dp")
	public @ResponseBody String addNewDepartment( @RequestParam String d_num 
												, @RequestParam String d_name) {
		
		Department departmentAddData = new Department();
		departmentAddData.setAll(d_num,d_name);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		departmentAddData.setCreate_date(timestamp);
		departmentAddData.setCreate_user("auto_system");
		departmentAddData.setUpdate_date(timestamp);
		departmentAddData.setUpdate_user("auto_system");
		
		departmentRepository.save(departmentAddData);
		
		return "登録しました";
	}

	// 従業員名簿
		@GetMapping(path="/all_ep")
		public String list_ep(Model model) {
			// M_EMPLOYEEテーブルの全データを取得
			Iterable<Employee> employeeList = employeeRepository.findAll();
			
			// モデルに属性追加
			model.addAttribute("employeelist",employeeList);

			// データ一覧画面を表示
			return "list_ep.html";
		}
		
		@RequestMapping("/insert_ep")
	    public String insert_ep() {
			// データ登録画面を表示
	        return "insert_ep.html";
	    }
		
		// DB登録処理
		@PostMapping(path="/register_ep")
		public @ResponseBody String addNewEmployee(	  @RequestParam String e_num 
													, @RequestParam String e_name
													, @RequestParam int e_year
													, @RequestParam String depart_cd) {
			
			Employee employeeAddData = new Employee();
			employeeAddData.setAll(e_num,e_name,e_year,depart_cd);
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			employeeAddData.setCreate_date(timestamp);
			employeeAddData.setCreate_user("auto_system");
			employeeAddData.setUpdate_date(timestamp);
			employeeAddData.setUpdate_user("auto_system");
			
			employeeRepository.save(employeeAddData);
			
			return "登録しました";
		}
	

}