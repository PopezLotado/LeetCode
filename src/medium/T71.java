package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Simplify Path
 * @Description Given an absolute path for a file (Unix-style), simplify it.
 * 
 *              For example, path = "/home/", => "/home" path =
 *              "/a/./b/../../c/", => "/c" click to show corner cases.
 * 
 *              Corner Cases: Did you consider the case where path = "/../"? In
 *              this case, you should return "/". Another corner case is the
 *              path might contain multiple slashes '/' together, such as
 *              "/home//foo/". In this case, you should ignore redundant slashes
 *              and return "/home/foo".
 *
 */
public class T71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T71 t71=new T71();
		System.out.println(t71.simplifyPath("/home//foo/"));
	}

	public String simplifyPath(String path) {
		List<String> res = new LinkedList<String>();
		int p = 0;
		while (p < path.length()) {
			while (p < path.length() && path.charAt(p) == '/')
				p++;
			StringBuilder sb = new StringBuilder("");
			while (p < path.length() && path.charAt(p) != '/'){
				sb.append(path.charAt(p));
				p++;
			}
			String dir = sb.toString();
			if (!dir.trim().isEmpty()) {
				if(dir.equals(".")){
					
				}else if(dir.equals("..")){
					if(!res.isEmpty()){
						res.remove(res.size()-1);
					}
				}else {
					res.add(dir);
				}
			}
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < res.size(); i++) {
			sb.append("/" + res.get(i));
		}
		if(sb.toString().isEmpty())
			sb.append("/");
		return sb.toString();
	}

}
