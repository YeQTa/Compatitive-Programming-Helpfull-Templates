import java.util.Stack;
/* 
  In this class, Queue is implemented with 2 stacks, and you can get minimum value of queue in O(1) time.
*/
public class MinQueueTemplate {

	private static class Pair{
		int val;
		int min;
		public Pair(int x, int y){
			val=x;
			min=y;
		}
	}
	
	private static class MinQueue{
		Stack<Pair> stackFirst;
		Stack<Pair> stackSecond;
		public MinQueue(){
			stackFirst = new Stack<Pair>();
			stackSecond = new Stack<Pair>();
		}
		
		
		public void add(int x){
			if (stackFirst.isEmpty()){
				stackFirst.push(new Pair(x,x));
			}
			else{
				Pair top=stackFirst.peek();
				int min=Math.min(top.min, x);
				stackFirst.push(new Pair(x,min));
			}
		}
		
		public int remove(){
			if(!stackSecond.isEmpty()){
				Pair pop=stackSecond.pop();
				return pop.val;
			}
			else{
				if(stackFirst.isEmpty()){
					return -1;
				}
				while(!stackFirst.isEmpty()){
					Pair f=stackFirst.pop();
					int min=f.val;
					if(!stackSecond.isEmpty()){
						Pair top=stackSecond.peek();
						min=Math.min(top.min, min);
					}
					stackSecond.push(new Pair(f.val,min));
				}
				Pair pop=stackSecond.pop();
				return pop.val;
			}
		}
		
		public int getMin(){
			int min=Integer.MAX_VALUE;
			if(!stackSecond.isEmpty()){
				Pair top=stackSecond.peek();
				min=Math.min(min, top.min);
			}
			if(!stackFirst.isEmpty()){
				Pair top=stackFirst.peek();
				min=Math.min(min, top.min);
			}
			return min;
		}
		
	}

	

	

	

	
	public static void main(String[] args) {
		MinQueue minq = new MinQueue();
		
		minq.add(0);
		System.out.println("min="+minq.getMin());
		minq.add(5);
		System.out.println("min="+minq.getMin());
		minq.add(3);
		System.out.println("min="+minq.getMin());
		minq.remove();
		minq.remove();
		minq.remove();
		minq.add(6);
		System.out.println("min="+minq.getMin());




	}
	
	
}
