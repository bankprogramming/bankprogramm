package de.bankprogramming.wrappers;

import de.bankprogramming.models.*;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class WrapperHelper {

    public static ProductWrapper wrapProduct(Product p){
        if(p instanceof Card){
            return new CardWrapper((Card) p);
        }else if(p instanceof PensionPlan){
            return new PensionPlanWrapper((PensionPlan) p);
        }else if(p instanceof Investment){
            return new InvestmentWrapper((Investment) p);
        }else if(p instanceof Mortgage){
            return new MortgageWrapper((Mortgage) p);
        }else if(p instanceof Credit){
            return new CreditWrapper((Credit) p);
        }else if(p instanceof Loan){
            return new LoanWrapper((Loan) p);
        }else if(p instanceof JuniorCurrentAccount){
            return new JuniorCurrentAccountWrapper((JuniorCurrentAccount) p);
        }else if(p instanceof Account){
            return new AccountWrapper((Account) p);
        }else {
            return new ProductWrapper(p);
        }
    }
}
