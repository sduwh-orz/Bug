package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.ModuleDTO;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.repository.ModuleRepository;
import cn.edu.sdu.orz.bug.vo.ModuleQueryVO;
import cn.edu.sdu.orz.bug.vo.ModuleUpdateVO;
import cn.edu.sdu.orz.bug.vo.ModuleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public String save(ModuleVO vO) {
        Module bean = new Module();
        BeanUtils.copyProperties(vO, bean);
        bean = moduleRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        moduleRepository.deleteById(id);
    }

    public void update(String id, ModuleUpdateVO vO) {
        Module bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        moduleRepository.save(bean);
    }

    public ModuleDTO getById(String id) {
        Module original = requireOne(id);
        return toDTO(original);
    }

    public Page<ModuleDTO> query(ModuleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ModuleDTO toDTO(Module original) {
        ModuleDTO bean = new ModuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public Module requireOne(String id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
