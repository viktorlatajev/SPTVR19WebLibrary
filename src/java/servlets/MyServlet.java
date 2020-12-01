import entity.Book;
import entity.Reader;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.ReaderFacade;

/**
 *
 * @author user
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/addBook",
    "/createBook",
    "/addReader",
    "/createReader",
    "/listBooks",
    "/listReaders",
    
})
public class MyServlet extends HttpServlet {
    @EJB 
    private BookFacade bookFacade;
    @EJB 
    private ReaderFacade readerFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        
        switch (path) {
            case "/addBook":
                request.getRequestDispatcher("/WEB-INF/addBookForm.jsp").forward(request, response);
                break;
            case "/createBook":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String publishedYear = request.getParameter("publishedYear");
                if("".equals(name) || name == null 
                        || "".equals(author) || author == null
                        || "".equals(publishedYear) || publishedYear == null){
                    request.setAttribute("info","Заполните все поля формы");
                    request.setAttribute("name",name);
                    request.setAttribute("author",author);
                    request.setAttribute("publishedYear",publishedYear);
                    request.getRequestDispatcher("/WEB-INF/addBookForm.jsp").forward(request, response);
                    break; 
                }
                Book book = new Book(name, author, Integer.parseInt(publishedYear));
                bookFacade.create(book);
                request.setAttribute("info","Добавлена книга: " +book.toString() );
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/addReader":
                request.getRequestDispatcher("/WEB-INF/addReaderForm.jsp").forward(request, response);
                break;
            case "/createReader":
                name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                if("".equals(name) || name == null 
                        || "".equals(lastname) || lastname == null
                        || "".equals(phone) || phone == null){
                    request.setAttribute("info","Заполните все поля формы");
                    request.setAttribute("name",name);
                    request.setAttribute("lastname",lastname);
                    request.setAttribute("phone",phone);
                    request.getRequestDispatcher("/WEB-INF/addReaderForm.jsp").forward(request, response);
                    break; 
                }
                Reader reader= new Reader(name, lastname, phone);
                readerFacade.create(reader);
                request.setAttribute("info","Добавлен(а) читатель: " +reader.toString() );
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listBooks":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/WEB-INF/listBooks.jsp").forward(request, response);
                break;
            case "/listReaders":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/WEB-INF/listReaders.jsp").forward(request, response);
                break;
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}