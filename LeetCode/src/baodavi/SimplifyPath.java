package baodavi;
import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] subDirs = path.split("/");
		List<String> tmpHelper = new ArrayList<String>();
		for (int i = 0; i < subDirs.length; i++) {
			String tmpStr = new String(subDirs[i]);
			if (tmpStr.isEmpty() || tmpStr.length() == 0) {
				continue;
			}

			if (tmpStr.equals(".")) {
				;
			} else if (tmpStr.equals("..")) {
				if (tmpHelper.isEmpty())
					;
				else
					tmpHelper.remove(tmpHelper.size() - 1);
			} else {
				tmpHelper.add(subDirs[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < tmpHelper.size(); j++) {
			sb.append("/" + tmpHelper.get(j));
		}
		if (sb.length() == 0)
			return "/";
		return sb.toString();
	}

	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		sp.simplifyPath("/...");
	}
}
