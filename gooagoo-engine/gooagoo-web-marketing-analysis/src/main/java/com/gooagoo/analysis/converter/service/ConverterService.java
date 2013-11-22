package com.gooagoo.analysis.converter.service;

import java.util.List;

import com.gooagoo.analysis.entity.Behave;

/**
 * 
 * @author YL
 * @param <T>
 *
 */
public interface ConverterService
{
    public List<Behave> getBehave(Object object) throws Exception;

}
