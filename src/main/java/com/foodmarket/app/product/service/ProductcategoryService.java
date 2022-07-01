//package com.foodmarket.app.product.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.foodmarket.app.product.model.ProductcategoryRepository;
//import com.foodmarket.app.product.model.WorkProduct;
//import com.foodmarket.app.product.model.WorkProductRepository;
//import com.foodmarket.app.product.model.productcategory;
//
//@Service
//@Transactional
//public class ProductcategoryService {
//	
//	
//
////	@Autowired
////	private ProductcategoryRepository productcategoryDao;
////
////	public List<productcategory> selectAll() {
////		
////		List<productcategory> productAll = productcategoryDao.findAll();
////		  return productAll;
////	}
////	public List<productcategory> insertproductcategory(WorkProductRepository pcmsg) {
////		productcategoryDao.save(pcmsg);
////	}
//	
//	//ID查詢
////		public List<productcategory> findBycategoryId(Integer categoryid) {
////			return  productcategoryDao.findBycategoryid(categoryid);
//////			Optional<productcategory> optional = productcategoryDao.findById(categoryid);
////			
//////			if (optional.isPresent()) {
//////				return optional.get();
//////				
//////			}
//////			return null;
////			
////		}
////
////	@Transactional
////	public productcategory getLastest() {
////		return productcategoryDao.findFirstByOrderByAddedDesc();
////	}
//////	//滑動圖有幾張就要幾張一頁 一般分頁要幾個一頁
////	public Page<productcategory> findByPage(Integer pageNumber) {
////		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.DESC, "added");
////
////		Page<productcategory> page = productcategoryDao.findAll(pgb);
////
////		return page;
////	}
//	
//	//商品一個一個排
////	public Page<WorkProduct> findByall(Integer productNumber) {
////		Pageable pgb = PageRequest.of(productNumber - 1, 1, Sort.Direction.DESC, "added");
////		
////		Page<WorkProduct> page = productDao.findAll(pgb);
////		
////		return page;
////	}
//	
//	//ID查詢
////	public WorkProduct findById(Long productid) {
////		Optional<WorkProduct> optional = productDao.findById(productid);
////		
////		if (optional.isPresent()) {
////			return optional.get();
////			
////		}
////		return null;
////	}
//	//商品查詢種類不分頁
////	public List<productcategory> findByProductcategoryKey(String productcategory) {
////		List<productcategory> page = productcategoryDao.findByProductcategory(productcategory);
////
//////		if(page.isPresent()) {
//////			return page.get();
//////			
//////		}
////		return page;
////	}
//	
//	
//	//商品查詢種類分頁
////	public Page<WorkProduct> findByProductcategorypage(String productcategorypage,Integer pageNumber) {
////		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.DESC, "added");
////		Page<WorkProduct> page = productDao.findByProductcategorypage(productcategorypage,pgb);
//		
////		if(page.isPresent()) {
////			return page.get();
////			
////		}
////		return page;
////	}
//	
//	
//	
//	//商品查詢分頁
////	public Page<WorkProduct> findByNamePage(String productname ,Integer pageNumber) {
////		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.DESC, "added");
////
////		Page<WorkProduct> page = productDao.findByNamePage(productname,pgb);
////
////		return page;
////	}
//	
//	//商品點擊查詢不分頁
////	public List<WorkProduct> findByName(String productname) {
////		List<WorkProduct> page = productDao.findByName(productname);
////
////		return page;
//
////		if (name.isPresent()) {
////			return name.get();
////
////		}
////		return null;
////	}
//	//商品輸入查詢不分頁
////	public List<WorkProduct> findByProductName(String productname) {
////		List<WorkProduct> page = productDao.findByName(productname);
////		
////		return page;
//		
////		if (name.isPresent()) {
////			return name.get();
////
////		}
////		return null;
////	}
//	
//	
//	//商品前台顯示上架不分頁
////	public List<WorkProduct> findByOn(String takedown) {
////		List<WorkProduct> page = productDao.findByOn(takedown);
////		
////		return page;
//		
////		if (name.isPresent()) {
////			return name.get();
////
////		}
////		return null;
////	}
//
//	//商品上架排序分頁 首頁
////	public Page<WorkProduct> findByTakeDown(String takedown ,Integer pageNumber) {
////		Pageable pgb = PageRequest.of(pageNumber - 1, 12, Sort.Direction.DESC, "added");
////		
////		Page<WorkProduct> page = productDao.findByTakeDown(takedown,pgb);
////		
////		return page;
////	}
//	
//	//	public WorkProduct findById(Long productid) {
////		Optional<WorkProduct> optional = productDao.findById(productid);
////		
////		if(optional.isPresent()) {
////			return optional.get();
////			
////		}
////		return null;
////	}
//
////	public Page<WorkProduct> findByproductcategory(Integer pageNumber,String productcategory){
////		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC,"added");
////		
////		Page<WorkProduct> page = productDao.findByproductcategory(pgb, productcategory);
////		
////		return page;
////	}
////	public Page<WorkProduct> findByName(Integer pageNumber,String productname){
////		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC,"added");
////		
////		Page<WorkProduct> page = productDao.findByName(pgb,productname);
////		
////		return page;
////	}
//
////		return new Page<WorkProduct>() {
////			@Override
////			public Predicate toPredicate(Root<WorkProduct> root) {
////				List<Predicate>
////			}
////		
////		}
////	}
//
////	public void deleteById(Long productid) {
////		 productDao.deleteById(productid);
////
////	}
//	
//	//判斷
////	public void validate(Object target, Errors errors) {
////		WorkProduct bean = (WorkProduct) target;
////		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productname", "", "商品名稱不能空白");
////		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productprice", "", "價格欄不能空白");
////		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mf", "", "圖不能空白");
////		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productdesciption", "", "商品介紹不能空白");
////		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "administrator", "", "庫存數量不能空白");
////		
//////		Double price = Double.parseDouble(bean.getListPrice());
////		
////		if (bean.getProductcategory().equals("0")) {
////			errors.rejectValue("productcategory","", "必須挑選分類欄");
////		}
////		if () {
////			if (bean.getProductimg().isEmpty()) {
////				errors.rejectValue("productImage","", "必須挑選圖片");
////			}
////		}
////	}
//
//	
//	
//	
//	//網路範例-------------------------------
////	public List<WorkProduct> findByName(String productname) {
////		Session session = sessionfactory.openSession();
////		
////		try {
////			session.beginTransaction();
////			
////			String hql = "FROM Customer AS c WHERE c.CustomerName like '%" + productname + "%'";
////			Query<WorkProduct> query = session.createQuery(hql, WorkProduct.class);
////			
////			session.getTransaction().commit();
////			
////			return query.getResultList();
////		}catch(Exception e) {
////			session.getTransaction().rollback();
////		}finally {
////			session.close();
////		}
////		
////		return null;
////	}
//
////	public PageInfo list(ProductListDto productListDto) {
////		ProductListQuery productListQuery = new ProductListQuery();
////	}
////	
//
////	public String encode(String str) {
////		try {
////			MessageDigest md = MessageDigest.getInstance("SHA-1");
////			md.update(str.getBytes("utf-8"));
////			byte[] digest = md.digest();
////			return byteToHexString(digest);
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			return null;
////		}
////	}
////
////	public static String byteToHexString(byte[] bytes) {
////		return String.valueOf(Hex.encodeHex(bytes));
////	}
////
////	public String encoder(byte[] textByte) {
////		final Base64.Encoder encoder = Base64.getEncoder();
////		final String encodedText = encoder.encodeToString(textByte);
////		return encodedText;
////	}
////
////	public byte[] decoder(String encodedText) {
////		final Base64.Decoder decoder = Base64.getDecoder();
////		byte[] decodedArray = decoder.decode(encodedText);
////		return decodedArray;
////	}
////
////	public byte[] inputToBytes(InputStream ins) {
////		byte[] inputArray = null;
////		try {
////			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
////			byte[] buff = new byte[128];
////			int rc = 0;
////			while ((rc = ins.read(buff, 0, 100)) > 0) {
////				swapStream.write(buff, 0, rc);
////			}
////			inputArray = swapStream.toByteArray();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////
////		return inputArray;
////	}
//
//}
