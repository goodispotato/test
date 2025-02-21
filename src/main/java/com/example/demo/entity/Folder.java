package com.example.demo.entity;

import com.example.demo.dto.FolderDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Folder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer folderId;

    @Column(name="folderName")
    private String folderName;

    @ManyToOne //유저 한 명 당 folder 여러 개
    @JoinColumn(name="userId")
    private User user;

    public static Folder createFolder(FolderDto folderDto, User user){
        return new Folder(
                folderDto.getFolderId(),
                folderDto.getFolderName(),
                user
        );
    }

    public void patch(Folder folder){
        if(folder.folderName!=null)
            this.folderName= folder.folderName;
    }

}
