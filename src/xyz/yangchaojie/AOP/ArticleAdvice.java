package xyz.yangchaojie.AOP;



public class ArticleAdvice {
	
	public void printUpdateOK(){
		
	}
	
	public void pringUpdateError(){
		System.out.println("更新失败!");
	}
	
	public void printAddArticleOK(){
		System.out.println("添加文章成功！");
	}
	
	public void printAddError(){
		System.out.println("添加文章失败!");
	}
}
