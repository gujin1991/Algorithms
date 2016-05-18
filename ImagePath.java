import java.util.*;
public class ImagePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test2 = "dir1\n dir11\n dir12\n  dir0\n   gu.png\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		String test = "a.jpg\ndir1\n dir11\n dir12\n  picture.jepg\n  dir121\n   jin.gif\n  file1.gif\ndir2\n file2.gif";
		String test1 = "dir1\n dir11\n dir12\n  picture.jepg\n  dir121\n  file1.gif\ndir2\n file2.gif";
		System.out.println(imagePath(test2));
		Map<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
	}
	
	public static int imagePath(String path) {
		if(path == null) {
			return 0;
		}
		
		TreeNode root = new TreeNode("root");
		String[] lines = path.split("\n");
		int len = lines.length;
		for(int i = 0; i < len; i++) {
			System.out.println(lines[i]);
			int spaceCnt = countSpaces(lines[i]);
			buildTrees(root, lines[i], spaceCnt);
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			
		}
		
		int cnt = 0;
		
		for(int i = 0; i < root.childs.size(); i++) {
			//System.out.println(root.childs.get(i).val);
			cnt += countPath(root.childs.get(i), 0);
		}
		
		//System.out.println(root.childs.get(0).childs.get(1).childs.get(0).val);
		
		return cnt;
	}
	
	private static boolean isImage(String str) {
		if(str.indexOf(".jpeg") != -1 || str.indexOf(".gif") != -1 || str.indexOf(".jpg") != -1) {
			return true;
		}
		
		return false;
	}
	
	private static int countPath(TreeNode root, int prefix) {
		//System.out.println(prefix);
		if(root == null) {
			return 0;
		}
		
		if(isImage(root.val)) {
			if(prefix == 0) {
				return 1;
			} else {
				return prefix;
			}
		}
		
		if(root.childs == null) {
			return 0;
		}
		
		int cnt = 0;
		for(int i = 0; i < root.childs.size(); i++) {
			//if(root.childHasImg)
			int path = countPath(root.childs.get(i), prefix + root.val.length() -  countSpaces(root.val) + 1);
			if(path > 0 && (!root.childHasImg || !isImage(root.childs.get(i).val))) {
				cnt += path;
				
					root.childHasImg = true;
			}
			//if(path )
		}
		
		return cnt;
	}
	
	private static int countSpaces(String str) {
		if(str == null) {
			return 0;
		}
		
		int cnt = 0;
		while(str.charAt(cnt) == ' ') {
			cnt++;
		}
		
		return cnt;
	}
	
	private static void buildTrees(TreeNode root, String val, int sCnt) {
		if(sCnt == 0) {
			root.childs.add(new TreeNode(val));
		} else {
			if(root.childs == null) {
				root.childs.add(new TreeNode(val));
			} else {
				int size = root.childs.size();
				buildTrees(root.childs.get(size - 1), val, sCnt - 1);
			}
		}
	}
	
	
	
	static class TreeNode {
		String val = "";
		boolean childHasImg;
		ArrayList<TreeNode> childs;
		
		public TreeNode(String val) {
			this.val += val;
			childHasImg = false;
			childs = new ArrayList<TreeNode>();
			
		}
	}

}
