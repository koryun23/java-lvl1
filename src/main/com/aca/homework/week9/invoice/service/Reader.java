package com.aca.homework.week9.invoice.service;

import java.util.List;

public interface Reader<T> {
    List<T> read();
}
