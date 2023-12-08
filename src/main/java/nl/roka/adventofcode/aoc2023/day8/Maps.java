package nl.roka.adventofcode.aoc2023.day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Maps {

  public static final Path AAA = Path.id("AAA");
  public static final Path ZZZ = Path.id("ZZZ");
  private final Sequence sequence;
  private final Map<Path, Node> nodes = new HashMap<>();

  public Maps(Sequence sequence) {
    this.sequence = sequence;
  }

  public static Maps parse(List<String> input) {
    var sequence = new Sequence(input.get(0));
    var maps = new Maps(sequence);

    for (int i = 2; i < input.size(); i++) {
      String node = input.get(i);
      maps.add(Path.id(node), new Node(Path.left(node), Path.right(node)));
    }
    return maps;
  }

  private void add(Path id, Node node) {
    nodes.put(id, node);
  }

  public char next() {
    return sequence.next();
  }

  public Node getAAA() {
    return nodes.get(AAA);
  }

  public Node getZZZ() {
    return nodes.get(ZZZ);
  }

  public Node get(Path a) {
    return nodes.get(a);
  }

  public PathGroup getEndingWithA() {

    return new PathGroup(nodes.keySet().stream().filter(Path::endsWithA).toList());
  }
}
