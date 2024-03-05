package com.zervlad.appnba.Core.Interfaces;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IAPI<T> {
    List<T> getAll() throws URISyntaxException, IOException;

    List<T> getWithParameters(String params) throws URISyntaxException, IOException;
}