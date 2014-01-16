class Anagram

  def initialize(word)
    @word = word
  end

  def match(candidates)
    candidates.select do |candidate|
      @word.chars.sort == candidate.chars.sort && @word != candidate
    end
  end
  
end
