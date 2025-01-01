package zitsolution.com.JavaWithJasper.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zitsolution.com.JavaWithJasper.dto.Publication;

import java.util.Arrays;
import java.util.List;

@Service
public class PublicationService {
    public List<Publication> fetchPublications() {
        String apiUrl = "http://157.230.251.1:8011/api/website/publication-list";
        RestTemplate restTemplate = new RestTemplate();
        Publication[] publications = restTemplate.getForObject(apiUrl, Publication[].class);
        return Arrays.asList(publications);
    }
}
