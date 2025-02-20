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
    private Integer memberId;
    private Integer placeId;
    private Integer folderId;

    public static BookmarkDto createBookmarkDto(Bookmark bookmark) {
        return new BookmarkDto(
                bookmark.getBookmarkId(),
                bookmark.getMember().getMemberId(),
                bookmark.getPlace().getPlaceId(),
                bookmark.getFolder().getFolderId()
        );
    }
}
