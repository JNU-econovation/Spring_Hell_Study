package com.econovation.third_project.agrregate;

import java.util.List;

public interface AdminPageQuery {
    String getType();
    List<?> execute();

}
