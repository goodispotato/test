package com.example.demo.dto;

import com.example.demo.entity.Bookmark;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookmarkDto {
    private Integer bookmarkId;
    private Integer userId;
    private Integer placeId;
    private Integer folderId;

    public static BookmarkDto createBookmarkDto(Bookmark bookmark) {
        return new BookmarkDto(
                bookmark.getBookmarkId(),
                bookmark.getUser().getUserId(),
                bookmark.getPlace().getPlaceId(),
                bookmark.getFolder().getFolderId()
        );
    }
}
