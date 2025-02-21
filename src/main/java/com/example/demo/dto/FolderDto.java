package com.example.demo.dto;

import com.example.demo.entity.Folder;
import lombok.AllArgsConstructor;
import com.example.demo.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class FolderDto {
    private Integer folderId;
    private String folderName;
    private Integer userId;

    public static FolderDto createFolderDto(Folder folder) {
        return new FolderDto(
                folder.getFolderId(),
                folder.getFolderName(),
                folder.getUser().getUserId()
        );
    }

    public Folder toEntity(User user) {
        return new Folder(this.folderId, this.folderName, user);
    }

}
