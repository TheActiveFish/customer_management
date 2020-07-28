package com.dao;

import java.util.List;
import com.domain.CbankForm;

public interface CbankDao {
  public List bankSelect();

  public void bankDelete(CbankForm bank);

  public void bankUpdate(CbankForm bank);

  public void bankInsert(CbankForm bank);

  public int bankCountId();

  public CbankForm bankSelectOne(CbankForm bank);
}
