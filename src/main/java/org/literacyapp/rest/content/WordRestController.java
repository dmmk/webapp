package org.literacyapp.rest.content;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.literacyapp.dao.WordDao;
import org.literacyapp.model.content.Word;
import org.literacyapp.model.enums.Locale;
import org.literacyapp.model.json.content.WordJson;
import org.literacyapp.rest.JavaJsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/content/word")
public class WordRestController {
    
    private Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private WordDao wordDao;
    
    @RequestMapping("/list")
    public List<WordJson> list(@RequestParam Locale locale) {
        logger.info("list");
        
        logger.info("locale: " + locale);
        
        List<WordJson> wordJsons = new ArrayList<>();
        for (Word word : wordDao.readAllOrdered(locale)) {
            WordJson wordJson = JavaJsonConverter.getWordJson(word);
            wordJsons.add(wordJson);
        }
        return wordJsons;
    }
}