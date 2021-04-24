package com.minchanghsu.controller;

import com.minchanghsu.entity.Book;
import com.minchanghsu.enums.ErrorCodeMsg;
import com.minchanghsu.enums.SuccessCodeMsg;
import com.minchanghsu.model.response.JSONResult;
import com.minchanghsu.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Minchang Hsu (Caster)
 * Date: 2021/4/23
 * Comment:
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	BookService bookService;

	/**
	 * 獲取 Book 清單
	 */
	@GetMapping("/")
	public ResponseEntity getBookList() {
		return ResponseEntity.ok(JSONResult.createResult(SuccessCodeMsg.COMMON_OK).addResult(bookService.findAll()));
	}

	/**
	 * 創建 Book
	 */
	@PostMapping
	public ResponseEntity createBook(@RequestBody Book book) {
		bookService.insertByBook(book);
		return ResponseEntity.ok(JSONResult.createResult(SuccessCodeMsg.COMMON_OK));
	}

	/**
	 * 取得 single Book 資訊
	 */
	@GetMapping("/{id}")
	public ResponseEntity getBook(@PathVariable Long id) {
		return ResponseEntity.ok(JSONResult.createResult(SuccessCodeMsg.COMMON_OK).addResult(bookService.findById(id)));
	}

	/**
	 * 更新 Book 資訊
	 */
	@PutMapping("/{id}")
	public ResponseEntity putBook(@PathVariable Long id, @RequestBody Book book) {
		var oldBookInfo = bookService.findById(id);
		if(oldBookInfo == null)
			return ResponseEntity.ok(JSONResult.createResult(ErrorCodeMsg.DB_QUERY_ERROR));
		BeanUtils.copyProperties(book, oldBookInfo,"id");
		bookService.update(oldBookInfo);
		return ResponseEntity.ok(JSONResult.createResult(SuccessCodeMsg.COMMON_OK));
	}

	/**
	 * 刪除 Book
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity deleteBook(@PathVariable Long id) {
		bookService.delete(id);
		return ResponseEntity.ok(JSONResult.createResult(SuccessCodeMsg.COMMON_OK));
	}
}
