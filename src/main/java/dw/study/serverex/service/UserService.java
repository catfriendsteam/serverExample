package dw.study.serverex.service;

import dw.study.serverex.domain.Type;
import dw.study.serverex.domain.User;
import dw.study.serverex.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public Map<String, Object> getUser(String username){
        Map<String, Object> result = new HashMap<>();
        if(repository.findByName(username).isPresent()){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        return result;
    }

    public Map<String, Object> join(Map<String,Object> map){
        Map<String, Object> result = new HashMap<>();
        if(map.get("success").equals(true)){
            User user = User.builder()
                    .name(map.get("username").toString())
                    .type(Type.MEMBER)
                    .lastAccessTime(new Date())
                    .build();
            if(repository.save(user) != null)
                result.put("success", true);
            else
                result.put("success", false);
        }else{
            result.put("success", false);
        }
        return result;
    }

    public Map<String, Object> checkDuplicateUser(String username){
        Map<String, Object> result = new HashMap<>();
        if(repository.findByName(username).orElse(null) == null){
            System.out.println("empty!");
            result.put("success", true);
            result.put("username", username);
        }
        else{
            result.put("success", false);
        }
//        result.put("success",repository.findByName(username));
        return result;
    }
}
