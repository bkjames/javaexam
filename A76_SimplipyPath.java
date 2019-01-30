package ama01;

public class A76_SimplipyPath {

	
//	*
//	 * Deque of strings (directories).
//	 * iterate path:
//	 *  if "/", continue,
//	 *  if ".", conitnue,
//	 *  if "..", poll last,
//	 *  else, add a new directory
//	 * in the end, build result from deque.
//	 */
	public String simplifyPath(String path) {
	    Deque<String> deque = new LinkedList<String>();
	    String[] splits = path.split("/");
	    for (String split : splits) {
	        // CATCH: must use "equals()" instead of "==",
	        // because 'split' is a variable!
	        // Also, 'split' could be empty string.
	        if (split.equals(""))
	            continue;
	        else if (split.equals("."))
	            continue;
	        else if (split.equals(".."))
	            deque.pollLast();
	        else
	            deque.addLast(split);
	    }
	    StringBuilder builder = new StringBuilder();
	    while (!deque.isEmpty()) {
	        String s = deque.pollFirst();
	        builder.append("/").append(s);
	    }
	    if (builder.length() == 0)
	        return "/";
	    return builder.toString();
	}
	 
	 
	public String simplifyPath(String path) {
	    Deque<String> stack = new LinkedList<>();
	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
	    for (String dir : path.split("/")) {
	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	        else if (!skip.contains(dir)) stack.push(dir);
	    }
	    String res = "";
	    for (String dir : stack) res = "/" + dir + res;
	    return res.isEmpty() ? "/" : res;
	}
	
	
	public String simplifyPath(String path) {
	    Stack<String> stack = new Stack<>();
	    String[] p = path.split("/");
	    for (int i = 0; i < p.length; i++) {
	        if (!stack.empty() && p[i].equals(".."))
	            stack.pop();
	        else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
	            stack.push(p[i]);
	    }
	    List<String> list = new ArrayList(stack);
	    return "/"+String.join("/", list);
	}
	
	public String simplifyPath(String path) {
        String[] parts = path.split("/");
        int sub = 0;
        int len = parts.length;
        int fast, slow;
        for( fast=1,slow=1; fast< len;fast++){
            switch(parts[fast]) {
                case "" :
                    break;
                case "." :
                    break; // optional
                case ".." :
                    if(slow>1) slow--;
                    break; // optional
                default:
                  if(parts[slow]!= parts[fast])parts[slow]= parts[fast];
                  slow++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(slow == 1)sb.append('/');
        for( fast=1; fast< slow;fast++){
            sb.append('/');
            sb.append(parts[fast]);
        }
                
        return sb.toString();
    }
}
