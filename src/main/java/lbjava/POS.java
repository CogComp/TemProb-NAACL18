// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000B49CC2E4E2A4D294D8E855800FF06D8094DCD28CF2A4CC17D2B4DCB29084CCC22584D20D450B1D558A6582E4DCB2E450275F25142768A79E9A52109F5CA1A96D862364835601A7414B5149CA49084263D45B00276ADA3B49000000

package lbjava;

import datastruct.Event;
import datastruct.TemporalEventPair;
import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.lang.Object;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import util.ParamLBJ;
import util.constants;


public class POS extends Classifier
{
  public POS()
  {
    containingPackage = "lbjava";
    name = "POS";
  }

  public String getInputType() { return "datastruct.TemporalEventPair"; }
  public String getOutputType() { return "discrete[]"; }

  public FeatureVector classify(Object __example)
  {
    if (!(__example instanceof TemporalEventPair))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'POS(TemporalEventPair)' defined on line 29 of local_ee.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    TemporalEventPair ep = (TemporalEventPair) __example;

    FeatureVector __result;
    __result = new FeatureVector();
    int __featureIndex = 0;
    String __value;

    __value = "" + (ep.event1.getPos());
    __result.addFeature(new DiscreteArrayStringFeature(this.containingPackage, this.name, "", __value, valueIndexOf(__value), (short) 0, __featureIndex++, 0));
    __value = "" + (ep.event2.getPos());
    __result.addFeature(new DiscreteArrayStringFeature(this.containingPackage, this.name, "", __value, valueIndexOf(__value), (short) 0, __featureIndex++, 0));
    __value = "" + (ep.event1.getPos() + ":" + ep.event2.getPos());
    __result.addFeature(new DiscreteArrayStringFeature(this.containingPackage, this.name, "", __value, valueIndexOf(__value), (short) 0, __featureIndex++, 0));

    for (int __i = 0; __i < __result.featuresSize(); ++__i)
      __result.getFeature(__i).setArrayLength(__featureIndex);

    return __result;
  }

  public String[] discreteValueArray(Object __example)
  {
    return classify(__example).discreteValueArray();
  }

  public FeatureVector[] classify(Object[] examples)
  {
    if (!(examples instanceof TemporalEventPair[]))
    {
      String type = examples == null ? "null" : examples.getClass().getName();
      System.err.println("Classifier 'POS(TemporalEventPair)' defined on line 29 of local_ee.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "POS".hashCode(); }
  public boolean equals(Object o) { return o instanceof POS; }
}

