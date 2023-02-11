package com.example.week05project.Service;

import com.example.week05project.Exception.ApiException;
import com.example.week05project.Model.Book;
import com.example.week05project.Model.Store;
import com.example.week05project.Repostry.BookRepository;
import com.example.week05project.Repostry.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookrepository;
    private  final StoreRepository storeRepository;

    private final StoreService storeService;
  

    public List<Book> getBooks()
    {
        return  bookrepository.findAll();

    }

    public Book getBookById(Integer bookId){
        Book book = bookrepository.findById(bookId).orElse(null);
        if(book == null)
            throw new ApiException("Book not found");
        return book;
    }



    public void addBook(Book Book)
    {
        bookrepository.save(Book);

    }
    public void updateBook(Integer id, Book book)
    {
           Book old=  getBookById(id);
            old.setName(book.getName());
            bookrepository.save(old);

    }

    public void deleteBook(Integer id){
        getBookById(id);
        bookrepository.deleteById(id);
    }


    public void assignStoreWithBook(Integer storeId, Integer bookId ) {

        Store store = storeService.getStoreById(storeId);
        Book book = getBookById(bookId);


        book.setStore(store);
        bookrepository.save(book);
    }


  //  Create endpoint that takes bookId and return number of books available

    public Integer getAvailableBooks(Integer id)
    {

        Book book = getBookById(id);
        return book.getBookCount();
    }

    //  Create endpoint that takes a book name and return all book information


    public Book getBookInfoByname (String name)
    {
       Book book= bookrepository.findBookByName(name);

       if (book==null)
       {

           throw new ApiException(" Not found");
       }

       return  book;


    }

    // Create endpoint that return all books under a specific genre


    public Book getBookInfoByGenre (String genre)
    {
        Book book= bookrepository.findBookByGenre(genre);

        if (book==null)
        {

            throw new ApiException(" Not found");
        }

        return  book;


    }



// back to
/*    public void assignTechWithCou(Integer techid, Integer courid)
    {
        Teacher teacher= teacherRepository.findTeacherById(techid);
        Book Book= bookrepository.findBookById(courid);
        if (Book==null|| teacher==null)
        {

            throw new ApiException(" Not found!");
        }

        Book.setTeacher(teacher);
        bookrepository.save(Book);


    }

    //Create endpoint that take Book id and return the teacher name for that class

    public String howIsTeacher (Integer idBook)
    {

        Book Book =bookrepository.findBookById(idBook);
        if (Book==null)
        {

            throw new ApiException(" Not found!");
        }

        return Book.getTeacher().getName();


    }


    public void assignStudentWithBook(Integer student_id, Integer Book_id)
    {

        Student student= studentRepository.findStudentById(student_id);
        Book Book= bookrepository.findBookById(Book_id);
        if (student==null || Book==null)
        {
            throw new ApiException(" Can not Assigned, Objects not found  ");

        }

        student.getBook().add(Book);
        Book.getStudents().add(student);
        studentRepository.save(student);
        bookrepository.save(Book);


    }

    //Create endpoint that takes class id and return the student list
    public List<Student> getStudentListbyBookId(Integer BookId)

    {

      Book Book= bookrepository.findBookById(BookId);
      List<Student> student= new ArrayList<>();



        if(Book==null)
        {
            throw new ApiException("  not found  ");

        }


        for (int i=0; i<Book.getStudents().size();i++) {

            student.add(Book.getStudents().get(i));

        }

        return student;




    }*/

}
