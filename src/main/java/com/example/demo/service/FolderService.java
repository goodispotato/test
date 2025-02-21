package com.example.demo.service;


import com.example.demo.dto.FolderDto;
import com.example.demo.entity.Folder;
import com.example.demo.entity.User;
import com.example.demo.repository.FolderRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FolderService {
    @Autowired
    private  FolderRepository folderRepository;


    @Autowired
    private UserRepository userRepository;


    public Folder create(FolderDto folderDto) {
        User user= userRepository.findById(folderDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
        Folder folder = Folder.createFolder(folderDto,user);
        return folderRepository.save(folder);
    }

    public Folder delete(Integer id) {
        //1. 대상 찾기
        Folder target = folderRepository.findById(id).orElse(null);
        //2. 잘못된 요청 처리
        if(target == null) {
            return null;
        }
        //3. 대상 삭제
        folderRepository.delete(target);
        return target;
    }

    @Transactional
    public Folder update(Integer id,FolderDto folderDto) {

        Folder target=folderRepository.findById(id).orElse(null);
        //3. 잘못된 요청 처리
        if(target == null) {
            return null;
        }
        //4. 업데이트 및 정상 응답
        if (folderDto.getFolderName() != null) {
            target.setFolderName(folderDto.getFolderName());
        }
        return folderRepository.save(target);

    }

    public List<Folder> showFolders() {return folderRepository.findAll();}
}
