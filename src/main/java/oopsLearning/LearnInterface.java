package oopsLearning;

public interface LearnInterface {
	
	void chrome(String a, String b);
	
	void firefox(String a, String b);
	
	void edge(String a, String b);
	
	interface NestedInterface {
		
		void nestedmethod1();
		
		void nestedmethod2();
		
		interface NestedNestedInterface {
			
			void nestednestedmethod1();
			
			void nestednestedmetho2();
		}
		
	}

}
