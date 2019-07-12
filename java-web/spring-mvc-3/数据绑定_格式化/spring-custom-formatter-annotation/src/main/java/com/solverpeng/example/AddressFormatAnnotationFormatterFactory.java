package com.solverpeng.example;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddressFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<AddressFormat> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<>(Arrays.asList(Address.class));
    }

    @Override
    public Printer<?> getPrinter(AddressFormat annotation, Class<?> fieldType) {
        return getAddressFormatter(annotation, fieldType);
    }

    @Override
    public Parser<?> getParser(AddressFormat annotation, Class<?> fieldType) {
        return getAddressFormatter(annotation, fieldType);
    }

    private AddressFormatter getAddressFormatter (AddressFormat annotation,
                                                  Class<?> fieldType) {
        AddressFormatter formatter = new AddressFormatter();
        formatter.setStyle(annotation.style());
        return formatter;
    }
}
