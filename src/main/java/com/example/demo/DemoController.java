package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/")
public class DemoController {
    
    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("getAll")
    public List<DemoTableEntity> getAll(){
        return this.demoRepository.findAll();
    }

    @PostMapping("add")
    public DemoTableEntity add(@RequestBody DemoTableEntity demoEntity){
        return this.demoRepository.save(demoEntity);
    }

    @PutMapping("update")
    public DemoTableEntity update(@RequestBody DemoTableEntity demoEntity){
        DemoTableEntity demoFromDb = demoRepository.findById(demoEntity.getId()).get();
        demoFromDb.setDemoTxt(demoEntity.getDemoTxt());         
        demoFromDb.setDemoNumber(demoEntity.getDemoNumber());                
        return this.demoRepository.save(demoFromDb);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Integer id){
        this.demoRepository.deleteById(id);
    }    
}
