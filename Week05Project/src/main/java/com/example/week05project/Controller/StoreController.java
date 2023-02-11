package com.example.week05project.Controller;


import com.example.week05project.DTO.LocationDTO;
import com.example.week05project.Model.Book;
import com.example.week05project.Model.Customer;
import com.example.week05project.Model.Location;
import com.example.week05project.Model.Store;
import com.example.week05project.Service.BookService;
import com.example.week05project.Service.CustomerService;
import com.example.week05project.Service.LocationService;
import com.example.week05project.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor

public class StoreController {

    private final BookService bookService;
    private final CustomerService customerService;
    private  final LocationService locationService;
    private  final StoreService storeService;


    @GetMapping("/get")
    public ResponseEntity getStore()
    {
        List<Store> stores= storeService.getStores();
        return  ResponseEntity.status(200).body(stores);

    }


    @GetMapping("/get/book")
    public ResponseEntity getBook()

    {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/get/customer")
    public ResponseEntity getCustomer()

    {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.status(200).body(customers);
    }





    @PostMapping("/add")
    public ResponseEntity addStore(@Valid @RequestBody Store store)

    {


        storeService.addStore(store);
        return ResponseEntity.status(200).body(" Store Added!");

    }
    @PostMapping("/add/location")
    public ResponseEntity addStoreLocation(@Valid @RequestBody LocationDTO cd)

    {

        locationService.addStoreLocation(cd);
        return ResponseEntity.status(200).body(" Store Address Added!");
    }

    @PostMapping("/add/book")
    public ResponseEntity addBook(@Valid @RequestBody Book book)

    {


        bookService.addBook(book);
        return ResponseEntity.status(200).body(" Book Added!");

    }



    @PostMapping("/add/customer")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer)

    {

       customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(" customer Added!");

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editStore(@Valid @RequestBody Store store,@PathVariable Integer id)

    {


        storeService.UpdateStore(store,id);
        return ResponseEntity.status(200).body(" Store updated!");

    }


    @PutMapping("/edit/book/{id}")
    public ResponseEntity editBook(@Valid @RequestBody Book book,@PathVariable Integer id)

    {


        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body(" Book updated!");

    }


    @PutMapping("/edit/customer/{id}")
    public ResponseEntity editCustomer(@Valid @RequestBody Customer customer,@PathVariable Integer id)

    {

        customerService.UpdateCustomer(customer,id);
        return ResponseEntity.status(200).body(" customer Updated");

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id)

    {


        storeService.DeleteStore(id);
        return ResponseEntity.status(200).body(" Store Deleted!");

    }


    @DeleteMapping("/delete/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id)

    {


        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(" Book Deleted!");

    }


    @DeleteMapping("/delete/customer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id)

    {

        customerService.DeleteCustomer(id);
        return ResponseEntity.status(200).body(" customer Deleted");

    }

    @DeleteMapping("/delete/location/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id)

    {

        locationService.deleteStoreLocation(id);
        return ResponseEntity.status(200).body(" Location Deleted");

    }





    @PostMapping("/add/storebook/{storeid}/{bookid}")
    public ResponseEntity assignStoreWithBook(@PathVariable Integer storeid, @PathVariable Integer bookid)
    {

        bookService.assignStoreWithBook(storeid,bookid);
        return ResponseEntity.status(200).body(" Done, Store Linked with Book in both way!");

    }

    @PostMapping("/add/storecustomer/{storeid}/{cusid}")
    public ResponseEntity assignStorehWithCou(@PathVariable Integer storeid, @PathVariable Integer cusid) {

        customerService.assignStoreWithCustomer(storeid, cusid);
        return ResponseEntity.status(200).body(" Done, customer Linked with store!");
    }

   //   Create endpoint that takes storeid and return all the books

    @GetMapping("/get/book/{storeid}")
    public ResponseEntity getBookByStoreId(@PathVariable Integer storeid)

    {
        List<Book> books = storeService.getBooksByStoreId(storeid);
        return ResponseEntity.status(200).body(books);
    }


  //  Create endpoint thar takes storeid and return all customers

    @GetMapping("/get/customer/{storeid}")
    public ResponseEntity getCustomersByStoreId(@PathVariable Integer storeid)

    {
        List<Customer> customers = storeService.getCustomersByStoreId(storeid);
        return ResponseEntity.status(200).body(customers);
    }



    //   Create endpoint that takes bookId and return number of books available

    @GetMapping("/get/bookavailable/{bookid}")
    public ResponseEntity getAvailableByBookId(@PathVariable Integer bookid)

    {
        Integer number = bookService.getAvailableBooks(bookid);
        return ResponseEntity.status(200).body(number);
    }




    //  Create endpoint that takes a book name and return all book information

    @GetMapping("/get/bookname/{bookname}")
    public ResponseEntity getInfoByBookName(@PathVariable String bookname)

    {
        Book book = bookService.getBookInfoByname(bookname);
        return ResponseEntity.status(200).body(book);
    }




   // Create endpoint that return all books under a specific genre

    @GetMapping("/get/bookgenre/{genre}")
    public ResponseEntity getInfoByGenre(@PathVariable String genre)

    {
        Book book = bookService.getBookInfoByGenre(genre);
        return ResponseEntity.status(200).body(book);
    }









}
