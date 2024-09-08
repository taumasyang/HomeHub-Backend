package com.laioffer.homehub.discussBoard;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discussBoard")
public class DiscussController {

  private final DiscussService discussService;

  public DiscussController(DiscussService discussService) {
    this.discussService = discussService;
  }

  @GetMapping
  public List<DiscussDto> getAllDiscusses() {
    return discussService.getAllDiscusses();
  }

  @PostMapping
  public void createDiscuss(DiscussDto discussDto) {
    discussService.createDiscuss(
        discussDto.userId(),
        discussDto.discussTitle(),
        discussDto.discussContent(),
        LocalDateTime.now().toString());
  }

  @PostMapping("/comment")
  public void createComment(CommentDto commentDto) {
    discussService.createComment(
        commentDto.discussId(),
        commentDto.userId(),
        commentDto.content());
  }

  @DeleteMapping("/{discussId}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteDiscuss(@PathVariable String discussId) {
    discussService.deleteDiscuss(
        discussId);
  }

}
