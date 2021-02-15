package ir.markaz.hoviat.service.helper;

import ir.markaz.hoviat.model.vo.basicinfo.countrydivision.CountryDivisionResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ControllerCacheManager {
    private Optional<CountryDivisionResponse> tree = Optional.empty();


    public void setTree(CountryDivisionResponse tree) {
        this.tree = Optional.ofNullable(tree);
    }

    public void evictTree() {
        this.tree = Optional.empty();
    }
    public Optional<CountryDivisionResponse> getTree() {
        return tree;
    }
}
