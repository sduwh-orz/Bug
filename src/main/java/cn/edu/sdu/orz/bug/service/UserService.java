package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.UserDTO;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.repository.UserRepository;
import cn.edu.sdu.orz.bug.vo.UserQueryVO;
import cn.edu.sdu.orz.bug.vo.UserUpdateVO;
import cn.edu.sdu.orz.bug.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String save(UserVO vO) {
        User bean = new User();
        BeanUtils.copyProperties(vO, bean);
        bean = userRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public void update(String id, UserUpdateVO vO) {
        User bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRepository.save(bean);
    }

    public UserDTO getById(String id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserDTO> query(UserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private User requireOne(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
