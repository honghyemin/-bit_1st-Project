<<<<<<< HEAD
Package sec01.ex01;
// change
=======
package sec01.ex01;
// 수정한 파일입니다.
>>>>>>> test
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init �޼��� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id"); // �� ���� ���۵� ���� getParameter() �� �̿�
		String user_pw = request.getParameter("user_pw");
		System.out.println("���̵� : " + user_id);
		System.out.println("��й�ȣ : " + user_pw);
		String[] subject = request.getParameterValues("subject"); // �ϳ��� name���� ���� ���� �����ϴ� ��� getParameterValues()�� �̿��� �迭 ���·� ��ȯ��.
		for ( String str : subject) {
			System.out.println("������ ���� : " + str);
		}
	}
	
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}


}
